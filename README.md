
# WhatsApp com Firebase!
Este aplicativo de mensagens para Android foi desenvolvido em Kotlin e utiliza Firebase para integrar funcionalidades essenciais de um app de mensagens. Com o objetivo de simular as funcionalidades básicas do WhatsApp, o aplicativo permite interação em tempo real entre usuários e oferece armazenamento e gerenciamento de dados usando os serviços do Firebase. Este projeto demonstra minhas habilidades em desenvolvimento mobile, o uso de bibliotecas modernas e a aplicação de boas práticas de programação, servindo como um meio para exercitar os estudos e consolidar meu aprendizado.

## Funcionalidades Principais
- **Autenticação de Usuário:** Integração com Firebase Authentication para registro, login e gerenciamento de sessões de usuário de forma segura.
- **Perfil de Usuário:** Atualização de informações de perfil, incluindo upload de foto usando Firebase Storage.
- **Envio de Mensagens:** Funcionalidade de chat em tempo real que permite aos usuários enviar e receber mensagens instantaneamente.
- **Notificações Push:** Notificações em tempo real utilizando Firebase Cloud Messaging para alertar os usuários sobre novas mensagens e eventos importantes.
- **Listagem de Contatos:** Visualização de contatos disponíveis no aplicativo com informações atualizadas." em ingles


## Estrutura e Organização da Arquitetura
O projeto utiliza a arquitetura MVVM (Model-View-ViewModel), que é amplamente adotada em aplicativos Android modernos. Esta arquitetura permite uma clara separação de responsabilidades, o que facilita a manutenção e o escalonamento do projeto. Veja como cada parte é organizada:

- **Model:** Representa a lógica de dados do aplicativo. Esta camada inclui classes que definem a estrutura de dados e o gerenciamento das operações de dados usando Firebase Firestore, garantindo que os dados do usuário e as mensagens sejam armazenados de forma eficiente e segura.

- **View:** Composta por Activities e Fragments, esta camada é responsável pela interface do usuário. As Views observam o estado das LiveData do ViewModel e refletem qualquer mudança de dados em tempo real. O uso de XML layouts proporciona uma UI bem organizada e modular.

- **ViewModel:** Esta camada gerencia a lógica de apresentação e atua como um intermediário entre o Model e a View. O ViewModel utiliza LiveData para expor dados à View, garantindo que qualquer atualização seja refletida na interface do usuário sem a necessidade de manipulação direta de UI nas Activities ou Fragments.


## Estrutura do Código
O projeto está organizado em diversos pacotes para manter a clareza e modularidade:

- **Activities:** Contém as telas principais do aplicativo, incluindo telas de login, registro, e a principal tela de chat.

- **Adapters:** Contém classes adaptadoras que são responsáveis por ligar os dados às Views, especialmente em listas como RecyclerView.

- **Fragments:** Inclui partes reutilizáveis da UI que podem ser combinadas para criar uma interface de usuário flexível.

- **Model:** Define as estruturas de dados utilizadas no aplicativo, como informações de usuários e mensagens.

- **Utils:** Inclui utilitários e constantes que ajudam a simplificar e centralizar aspectos repetitivos do código, como strings de chave do Firebase.

- **Layouts:** A pasta res/layout contém arquivos XML que definem a UI para cada Activity e Fragment, mantendo uma estrutura limpa e reutilizável para diferentes tamanhos e orientações de tela.

- **Drawables:** Recursos visuais utilizados na aplicação, incluindo ícones e backgrounds.

- **Menu:** A pasta menu contém recursos de menu que fornecem opções para acessar o perfil do usuário e realizar logout, facilitando a navegação e a gestão de sessão no aplicativo.

- **Values:** A pasta values armazena definições de cores customizadas usadas em todo o aplicativo, garantindo consistência visual e facilitando a manutenção das cores da interface.

- **Themes:** A pasta themes contém definições de estilos para a aplicação, incluindo a personalização de botões e a configuração do tema base, proporcionando uma aparência coesa e adaptável ao aplicativo.
## Tecnologias e Ferramentas

- **Linguagem:** Kotlin, essencial para desenvolvimento Android moderno.

- **Firebase:** Firebase Authentication para gestão de usuários; Firestore como banco de dados NoSQL para armazenamento e recuperação de dados; Storage para armazenamento de fotos de perfil e outros arquivos.

- **Picasso:** Biblioteca para carregamento e caching de imagens de forma eficiente.

- **Android Jetpack Components:** LiveData para gerenciar ciclos de vida de dados e atualizações de UI reativas; ViewModel para manter dados relacionados à UI e sobrevivência às mudanças de configuração.

- **Kotlin Coroutines:** Para gerenciamento de threads assíncronas e simplificação do código que lida com operações em segundo plano.

## Boas Práticas e Fundamentos Aplicados
Neste projeto, várias boas práticas foram aplicadas para garantir um código limpo, eficiente e escalável:

- **Arquitetura MVVM:** Separação de lógica de negócios e apresentação, facilitando a manutenção e a testabilidade do código.

- **Injeção de Dependência:** Uso de bibliotecas para gerir a injeção de dependência, promovendo modularidade.

- **Gerenciamento de Estado com LiveData:** As atualizações em tempo real são tratadas de forma eficiente com LiveData, garantindo que a UI esteja sempre sincronizada com os dados.

- **Programação Reativa com Coroutines:** Utilização de corrotinas para lidar com operações assíncronas, mantendo o código simples e evitando a necessidade de callbacks complexos.

- **Gerenciamento de Recursos:** Uso eficaz de recursos como imagens e strings, para garantir que o aplicativo seja eficiente e fácil de manter.

- **Teste de Unidade e Integração:** Implementação de testes para garantir a qualidade e funcionalidade do código.


## Aprendizados

O que você aprendeu construindo esse projeto?
Este projeto me permitiu aprofundar meu entendimento sobre o ciclo de vida das Activities e Fragments, aprimorando minha habilidade de gerenciar estados e transições dentro da aplicação. Aprendi a manipular e obter dados do Firebase de forma mais eficiente, consolidando meus conhecimentos na integração com serviços de backend. Também melhorei minha capacidade de interpretação do Logcat, o que é crucial para a depuração e resolução de problemas. Além disso, reconheci a importância de utilizar constantes em projetos maiores para manter o código organizado e reduzir a propensão a erros.


Quais desafios você enfrentou e como você superou-os?
Enfrentei desafios significativos com o APK do emulador, que impediu o progresso do desenvolvimento por alguns dias. Além disso, encontrei problemas com a biblioteca de drawables do Android Studio, que ocasionalmente desaparecia. Para superar esses obstáculos, recorri a fóruns e vídeos de outros programadores que enfrentaram problemas semelhantes, obtendo soluções e dicas valiosas que me ajudaram a resolver os desafios técnicos e avançar com o desenvolvimento do projeto.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.
