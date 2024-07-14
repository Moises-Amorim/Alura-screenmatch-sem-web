package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private  final String API_KEY = "&apikey=309e9fcf";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {

        System.out.println("Digite o nome da serie para a busca:");
        var nomeSerie = scanner.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i<= dadosSerie.TotalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);

            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dadosSerie.TotalTemporadas(); i++) {
            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++){
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }
        //Lambdas: (parametro) -> expressao
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 10 episodios: ");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A "))
                .peek(i -> System.out.println("Priemiro filtro(N/A) " + i))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .peek(i -> System.out.println("Ordenação " + i))
                .limit(10)
                .peek(i -> System.out.println("Limitando 10 ep " + i))
                .map(e -> e.titulo().toUpperCase())
                .peek(i -> System.out.println("Mapeando a lista e colocando do titulo em maiusculo " + i))
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                    .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("Digite o nome do episodio: ");
        var trechoTitulo = scanner.nextLine();
        Optional<Episodio> episodioEncontrado = episodios.stream()
                .filter(e -> e.getTitulo().toLowerCase().contains(trechoTitulo.toLowerCase()))
                .findFirst();
        if (episodioEncontrado.isPresent()) {
            System.out.println("Episodio encontrado! " + episodioEncontrado.get());
        } else {
            System.out.println("Episodio não encontrado!");
        }

        System.out.println("A partir de que ano você deseja assistir os episodios?");
        var ano = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getDataLancamento() !=null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                        ", Episodio: " + e.getNumeroEpisodio() +
                        ", Titulo: " + e.getTitulo() +
                        ", Data de Lançamento: " + e.getDataLancamento().format(formatador)
                ));

        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println("Media das temporadas: " + avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println("Média das avaliações da série: " + est.getAverage() +
                ", Nota do pior episodio: " + est.getMin() +
                ", Nota do melhor episodio: " + est.getMax() +
                ", Quantidade de episodios: " + est.getCount()
        );
    }
}
