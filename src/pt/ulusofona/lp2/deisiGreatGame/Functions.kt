package pt.ulusofona.lp2.deisiGreatGame


enum class  CommandType {
    GET,POST;

}
fun getPlayer(manager: GameManager, args: List<String>): String?{
    return null;
}

fun router( ):((CommandType) -> (GameManager, List<String>) -> String)? {
    return null;
    //return funcao comando
}

/*
 * GET PLAYER <playerFirstName>
 * Obtém a informação do jogador cujo primeiro nome é igual ao parâmetro. A informação é a mesma que a apresentada pelo toString(), no mesmo formato
 * Ex:
 * GET PLAYER Ada
 * 3 | Ada Lovelace | 1 | No tools | Ada | Em Jogo
 * Caso o jogador não exista, deve retornar “Inexistent player”
 */

/*
 * GET PLAYERS_BY_LANGUAGE <language>
 * Obtém a lista de jogadores associados a uma certa linguagem, separados por vírgula.
 * Exemplo:
 * GET PLAYERS_BY_LANGUAGE Ruby
 * Pedro,Bruno
 * Caso não exista nenhum jogador associado a essa linguagem, deve escrever None
 */

/*
 * GET POLYGLOTS
 * Obtém a lista com todos os programadores associados a mais do que uma linguagem de programação,
 * ordenados por ordem crescente de número de linguagens. O resultado deve ser uma String com várias linhas em que cada linha tem o seguinte formato:
 * NOME_PROGRAMADOR:NUMERO_DE_LINGUAGENS
 * Exemplo:
 * Joshua Bloch:3 Brunito:4
 * Caso hajam empates, a ordem é indiferente.
 */

/*
 * GET MOST_USED_POSITIONS <max_results>
 * Obtém as posições do tabuleiro que mais jogadores “pisaram”, ordenadas da mais “pisada” para a menos “pisada”.
 * O resultado deve ser uma String com várias linhas em que cada linha tem o seguinte formato:
 * POSICAO:NUMERO_DE_PISADELAS
 * O parâmetro <max_results> é um inteiro indicando o número máximo de resultados que deve ser retornado.
 * Para efeitos de testes, não haverão empates.
 * NOTA: A posição 1 não entra para esta estatística.
 * Também não entram posições que os jogadores tenham pisado como consequência de um abismo.
 * Por exemplo, se o jogador se movimentar para a casa 5 onde está um abismo que o faz recuar 1 casa, apenas a casa 5 conta como “pisadela”.
 */


/*
 * GET MOST_USED_ABYSSES <max_results>
 * Similar ao anterior, mas agora pretendem-se apenas os abismos nos quais os jogadores mais caíram,
 * ordenados do que mais caíram para o que menos caíram.
 * O resultado deve ser uma String com várias linhas em que cada linha tem o seguinte formato:
 * TITULO_TIPO_ABISMO:NUMERO_DE_QUEDAS
 * O TITULO_TIPO_ABISMO tem que coincidir com o título indicado na tabela de abismos (ver parte 2)
 * O parâmetro <max_results> é um inteiro indicando o número máximo de resultados que deve ser retornado.
 * Para efeitos de testes, não haverão empates.
 * Se houverem várias abismos do mesmo tipo, deve ser retornado apenas aquele que tem mais “quedas”.
 * Só contam os abismos sobre o qual o jogador caiu diretamente e não como consequência de outro abismo
 * (ex: se o jogador cai num abismo e recua para outro abismo, só conta o primeiro).
 * Para efeitos de teste, os jogadores não terão ferramentas, por isso sofrem sempre a consequência do abismo.
 */

/* POST MOVE <numero de posições>
 * Move o jogador atual tantas posições quantas o parâmetro.
 * Caso a posição onde o jogador vai parar não tenha nenhum abismo nem ferramenta, deverá retornar “OK” Exemplo:
 * POST MOVE 3
 * OK
 * (Faz avançar o jogador atual 3 posições)
 * Caso o jogador vá parar a um abismo ou ferramenta, deverá mostrar a mensagem retornada pela função reactToAbyssOrTool Exemplo:
 * POST MOVE 3
 * Caiu num ciclo infinito!
 * Assuma que o <número de posições> é sempre um inteiro entre 1 e 6.
 */

/* POST ABYSS <abyssTypeId> <position>
 * Insere um abismo do tipo abyssTypeId na posição indicada.
 * Caso tenha sucesso, deverá retornar “OK”.
 * Caso a posição já esteja ocupada por um abismo ou ferramenta, deverá retornar “Position is occupied”.
 * Apenas serão testados estes 2 casos.
 * Podem p .
 */