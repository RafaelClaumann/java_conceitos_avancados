# Base64

- **Localização e Função**: A classe `Base64`, introduzida no Java 8 e localizada no pacote `java.util`, fornece métodos convenientes para codificar e decodificar dados em Base64, um esquema de codificação que transforma dados binários em texto.

- **Métodos Estáticos**: A classe oferece métodos como `Base64.getEncoder()` e `Base64.getDecoder()`, que retornam instâncias para codificar e decodificar dados, respectivamente, permitindo operações de forma prática e rápida.

- **Tipos de Codificadores e Decodificadores**:
  - **Alfabético (Standard)**: Codifica os dados usando o alfabeto Base64 padrão, que inclui letras maiúsculas, minúsculas, números e os caracteres '+' e '/'.
  - **URL e Nome de Arquivo**: Essa variante usa um alfabeto seguro para URLs e nomes de arquivos, substituindo os caracteres '+' e '/' por '-' e '_', evitando conflitos em URLs e nomes de arquivos.
  - **MIME (RFC 2045)**: Este tipo insere quebras de linha a cada 76 caracteres, seguindo o padrão MIME para facilitar a transmissão de dados em e-mails.

- **Relação com UTF-8**: Quando usamos a codificação Base64 em Java, é comum codificar `String` em UTF-8 antes de aplicar a transformação para Base64. UTF-8 é o formato padrão de codificação de `String` em Java e representa cada caractere como uma sequência de 1 a 4 bytes, dependendo da complexidade do caractere.

- **Uso Comum**: A codificação Base64, especialmente quando combinada com UTF-8, é amplamente usada para representar dados binários em formatos de texto, como JSON e XML. Em APIs REST, por exemplo, dados como imagens ou arquivos podem ser transmitidos em formato Base64 (codificados em UTF-8), o que facilita a integração e a interoperabilidade entre sistemas.
