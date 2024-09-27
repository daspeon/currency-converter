<h1 align="center"> 💱 Currency Converter</h1>

## Table of Contents

- [About](#about)
- [Requirements](#requirements)
- [Installing](#installing)
  - [Configuring](#configuring)
- [Usage](#usage)
- [Preview](#preview)

## About

This is a challenge provided by [ONE - Oracle Next Education](https://www.oracle.com/br/education/oracle-next-education/). It's a simple Command Line Interface (CLI) to convert currencies using [ExchangeRate API](https://www.exchangerate-api.com/). At this moment, you can't choose which currencies you want to convert, just use the available options.

## Requirements:

- [Java](https://www.oracle.com/java/technologies/downloads/?er=221886#java17) version 17 or higher
- [Maven](https://maven.apache.org/download.cgi) version 3.6.3 or higher

## Installing:

### Configuring

Clone the repository and run the following command inside the root folder to compile the project:

```bash
$ mvn compile
```

## Usage

Yet on the root folder, run the following command to see available options:

```bash
$ mvn exec:java
```

## Preview

```text
*******************************
*     CONVERSOR DE MOEDAS     *
*******************************
                   
1 - Dólar para Real
2 - Euro para Dólar
3 - Real para Iene
4 - Real para Libra Esterlina
5 - Dólar para Iene
6 - Real para Peso Argentino
                   
******************************
```

[⬆ Back to the top](#--currency-converter)
