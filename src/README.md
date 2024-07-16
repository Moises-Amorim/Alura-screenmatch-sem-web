# O que aprendi e aplicamos durante as aulas:


# Java trabalhando com Lambdas, streams e Spring Framework:

  -  Estrutura de um Projeto Spring: Vimos a estrutura inicial de um projeto Spring e discutimos sobre os pacotes, classes e o método run.

  -  Inferência de tipos no Java: Vimos um exemplo prático de inferência de tipos com 'var' no código Java.

  -  Consumo de API: Aprendemos a consumir APIs através do método 'obterDados', que retorna os dados desejados no formato Json.

  -  Modularização de código: Aprendemos a importância de ter um código modularizado e de fácil manutenção.

   - Serialização e Desserialização: Aprendemos como transformar JSON em classes e como isso é útil para o projeto.

   - Criação de interfaces e implementação de métodos: Foi demonstrada a criação de uma interface com um método genérico que usa Generics, bem como a implementação deste método em uma classe separada.

   - Inclusão de novas dependências no Projeto: Vimos como adicionar uma nova dependência ao arquivo .pom.xml e como esse processo é gerenciado pelo Maven.

  -  Desenvolvimento Colaborativo: Discutimos a importância do desenvolvimento colaborativo em projetos de programação e como ferramentas como o Git facilitam esse processo.

  -  APIs e Consultas Detalhadas: Descobrimos como trabalhar com APIs para detalhar informações e obter consultas mais específicas.

  -  Utilização de anotações @JsonAlias e @JsonIgnoreProperties: A importância de usar essas funções para mapear a API para a aplicação.

  -  Criação de métodos para interação do usuário: Criamos um método para exibir o menu e interagir com o usuário, permitindo que digitem o nome da série que desejam pesquisar.

  -  Manipulação de dados de uma API: Mostramos como importar e manipular dados de uma API, neste caso, dados de séries de TV.

  -  Manipulação de Strings para acessar uma API: Vimos como manipular strings para criar endereços que a API compreenderá e retornará os dados desejados.

  -  Introdução aos Lambdas: Conhecemos o Lambda Expressions em Java, conhecidas como funções anônimas que podemos usar para escrever código mais eficiente.

  -  Introdução às Funções Lambda: Aprendemos a sintaxe das funções lambda em Java e como elas permitem uma escrita mais concisa.

  -  Uso de Streams em Java: Obtemos um entendimento essencial das streams, que são fluxos de dados em Java, e como realizar operações encadeadas neles.

  -  Filtragem de Dados: Aprendemos como usar o recurso de filtragem em streams para selecionar apenas dados específicos, neste caso, episódios de séries de TV com avaliação específica.

  -  Manipulando Datas: Exploramos como converter strings em LocalDates e tratamos possíveis exceções que podem ocorrer neste processo.

  -  Tratando Exceções: Fizemos tratamento de exceções específicas, como NumberFormatException e DateTimeParseException, que podem ocorrer devido à conversão de dados.

  -  Uso da função peek: Foi introduzida a função peek no Java, que permite visualizar o que está acontecendo em cada etapa da stream, facilitando o processo de debug.

  -  Operações Intermediárias e Finais: Aprendemos sobre a utilização de operações (como map, filter e find) que nos permitem manipular e encontrar dados dentro de um Stream.

  -  Uso de Containers para Dados: Examinamos como usar o Container Optional para armazenar um episódio dentro de um Stream e evitar referências nulas.

  -  Filtragem de dados: Aprendemos a importância de filtrar dados adequados para análises e como isso pode afetar os resultados.

  -  Uso do DoubleSummaryStatistics: Aprendemos como a classe Double Summary Statistics do Java pode ajudar a analisar informações, como a maior avaliação, a menor e a quantidade de avaliações em nossas séries.

# Java: Persistência de dados e consultas com Spring Data JPA

   - Buscar várias séries na API. Criamos um loop que encerra somente quando o usuário escolhe sair do menu, sendo capaz de buscar várias séries na API sem parar.

   - Métodos privados. Vimos que, se apenas uma classe irá acessar um método, não precisamos deixá-lo público, podemos declará-lo como privado. Isso é essencial para o encapsulamento das nossas classes.

   - Adicionar mais informações aos dados buscados. Revisamos como realizar o mapeamento entre atributos da API e atributos da nossa record.

   - Converter os dados que vêm da API para a sua própria classe. Criamos nossa própria classe Serie para representar melhor nossos dados. Para isso, foi necessário utilizar vários métodos de conversão.

   - Utilizar um “ifreduzido”. Utilizamos a classe OptionalDouble para lidar com valores decimais e seus possíveis erros, utilizando os métodos ofe orElse, que lembram muito o código de um if reduzido, e são muito úteis para evitar que ocorram Exceptions.

   - Criar um Enum. Percebemos que seria excelente poder categorizar nossas séries por gênero. Criamos um enum para isso, e vimos como criar métodos personalizados em enums.

   - Consumir a API do ChatGPT. Utilizamos a API do ChatGPT para traduzir nossos dados, adicionamos todas as dependências necessárias e configuramos a classe de consumo.

   - Configurar seu ambiente Postgres. Fizemos a instalação desse banco de dados relacional e vimos a diferença entre bancos relacionais e outros tipos de bancos de dados, além de criar nosso banco de séries no Postgres.

   - Preparar sua aplicação para trabalhar com banco de dados. Adicionamos a dependência da JPA ao pom.xml e as configurações do banco de dados no application.properties.

   - Utilizar anotações do Hibernate para mapear suas entidades. Usamos anotações como @Entity, @Transient e @Column na classe Serie, indicando como seriam as configurações da tabela correspondente no banco de dados.

   - Manipular interfaces do tipo Repository. Para fazer operações básicas no banco de dados, como um CRUD, precisamos de uma interface do tipo Repository com o nosso tipo de dados. No nosso caso, criamos a SerieRepository.

   - Injetar dependências. Vimos que não podemos instanciar uma interface do tipo Repository em qualquer lugar. Elas precisam ser declaradas em classes gerenciadas pelo Spring, precedidas de um @Autowired, indicando que está sendo realizada uma injeção de dependências.

   - Trabalhar com variáveis de ambiente. Utilizamos variáveis de ambiente para proteger dados sensíveis da conexão com o banco de dados e com a API.

   - Mapear relacionamentos entre entidades da JPA. Conhecemos o uso das anotações @OneToMany e @ManyToOne para identificar o relacionamento ”um para muitos” de séries e episódios.

   - Conhecer diversos tipos de relacionamento: Identificamos qual era o relacionamento presente na nossa aplicação, além de ter conhecimento dos vários tipos de relacionamento em banco de dados.

   - Associar chaves estrangeiras. Entendemos o conceito de chave estrangeira, que é como o banco de dados identifica e configura relacionamentos.

   -Trabalhar com os tipos de Cascade. Como o nosso fluxo de salvamento de dados era salvar séries e depois episódios, foi preciso configurar isso utilizando o atributo Cascade.

   - Identificar como os dados são carregados. Trabalhamos também com o atributo fetch, que fala sobre carregar os dados de forma “preguiçosa” (lazy) ou “ansiosa” (eager).

   - Configurar relacionamentos bidirecionais. Vimos a importância de relacionamentos bidirecionais e deixamos as modificações aparecendo dos dois lados da relação, fazendo tanto setEpisodios() na Série quanto setSerie() nos Episodios.

   - Criar queries derivadas com a JPA. Conhecemos o recurso padrão da JPA para fazer buscas utilizando palavras-chave em métodos na classe Repository.

   - Comparar streams e buscas no banco de dados. Percebemos as mudanças em utilizar streams e as derived queries na nossa aplicação.

   - Conhecer diversas palavras-chave para criar seus métodos. Aprofundamos nas palavras-chave e em como utilizá-las, reforçando a prática.

   - Discutir os vários tipos de retorno ao realizar as buscas. Conversamos sobre as diferenças entre retornar uma série, uma lista de séries ou um Optional de séries.

   - Ler dados dinamicamente e armazenar em um Enum. Vimos como fazer a correspondência entre o que está sendo digitado e um campo no enum.

   - Diferenciar os tipos de consulta da JPA. Vimos que podemos trabalhar com derived queries, com queries nativas usando o nativequery e a JPQL, que é a linguagem de buscas da JPA.

   - Criar métodos totalmente personalizados e mais legíveis. Vimos que utilizar a JPQL pode auxiliar na escrita de métodos mais legíveis. Para isso, basta escrever o nome do método e anotá-lo com @Query.

   - Aprofundar em linguagem SQL. Conhecemos várias expressões utilizadas em SQL, como LIKE, ORDER e LIMIT.

   - Recuperar informações secundárias. Conseguimos buscar informações relacionadas a episódios a partir da série, utilizando o recurso das junções (JOIN).

   - Comparar recursos SQL e Java. Percebemos que, assim como o Java tem uma API de datas, o SQL também tem sua forma de lidar com datas. No nosso caso, utilizamos a função YEAR do SQL.

# Java criando primeira API e conectando ao Front
 - Conectar o back-end ao front-end. Vimos que o front-end esperava buscar dados de uma url específica, que era localhost:8080, que é onde subimos nosso servidor.

 - Configurar uma aplicação web com o Spring Boot. Conhecemos a dependência starter-web do Spring, que baixa várias outras dependências e configura automaticamente um servidor na porta localhost:8080, ou em alguma outra que configuremos na nossa aplicação.

 - Organizar um projeto MVC. Aprendemos como estruturar o projeto em várias camadas e como conectá-las.

 - Retornar uma informação no navegador. Criamos nosso primeiro controller e nossa primeira rota da API, utilizando anotações como @RestController e @GetMapping.

 -  Devolver os dados do nosso banco para o navegador. Trabalhamos devolvendo os dados do nosso banco no Controller, devidamente serializados.

 - Tratar serialização circular. Vimos os problemas que ocorrem ao tentar serializar entidades mapeadas de forma bidirecional e como resolvê-los.

 -  Utilizar o padrão DTO. Para evitar a serialização circular e principalmente para seguir boas práticas, criamos nossos DTOs. Assim, nossos dados ficaram mais seguros e foram devolvidos de forma personalizada.

 -  Lidar com o erro de CORS. Conhecemos o erro entre a comunicação entre rotas de origens diferentes e pudemos tratá-lo, criando a classe CorsConfiguration.

 -  Configurar o Live Reload. Para que a aplicação não precise ser parada e reinicializada sempre que houver mudanças, usamos o Devtools e mudamos as configurações necessárias no Intellij.

 -  Deixar o código mais limpo e organizado. Vimos que a única responsabilidade de um controlador é tratar da comunicação e das rotas da API. Assim, ele não deve conter regras de negócio. E para fazer essa divisão, criamos uma classe de serviços, a SerieService.

 -  Utilizar boas práticas de extração de métodos Aplicamos princípios da orientação a objetos, extraindo métodos que eram comuns no código, facilitando a manutenção.

 -  Criar uma url fixa para o Controller. Usamos o @RequestMapping para que todas as urls mapeadas pelo controlador de séries tenham como prefixo o “/series”.

 -  Retornar os dados de uma única série. Para buscar uma série, precisamos que seu id seja passado como parâmetro. Conhecemos o @PathVariable, que nos auxilia nesse objetivo.  

 -   Trabalhar de forma colaborativa. Vimos que é importante sempre testar exaustivamente o código, principalmente com registros diferentes. Somente assim temos a confirmação de que nossas buscas estão corretas.

 -   Passar parâmetros na url. Usamos novamente a anotação @PathVariable e vimos que ela pode ser utilizada tanto com números quanto com strings. Para que ela funcione, basta que passemos o nome do parâmetro entre chaves na url do @GetMapping, exatamente como ele está declarado na função.

 -   Comparar streams e buscas no banco de dados. Aprendemos que podemos utilizar tanto streams quanto consultas do banco de dados, não precisamos nos restringir ao uso exclusivo de um deles. Basta que analisemos a complexidade das buscas, filtros e operações que faremos.

 -   Desenvolver uma aplicação de forma incremental. Ao trabalhar na integração do front com o back-end, identificamos, ao longo do tempo, os requisitos necessários para tudo funcionar em conjunto. O trabalho incremental é muito comum no ambiente de desenvolvimento.