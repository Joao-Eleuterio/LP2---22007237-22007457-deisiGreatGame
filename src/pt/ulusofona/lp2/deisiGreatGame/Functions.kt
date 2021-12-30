package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType {
    GET, POST;
}

fun router(): (CommandType) -> (GameManager, List<String>) -> String? {
    return { commandType -> comando(commandType) }
}

fun comando(commandType: CommandType): (GameManager, List<String>) -> String? {

    when (commandType) {
        CommandType.GET -> return { manager, args -> commandTypeGet(manager, args) }
        CommandType.POST -> return { manager, args -> commandTypePost(manager, args) }
    }

}

fun commandTypePost(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "MOVE" -> return PostMove(manager, args)
        "ABYSS" -> return PostAbyss(manager, args)
    }
    return null
}

fun commandTypeGet(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "PLAYER" -> return getPlayer(manager, args)
        "PLAYERS_BY_LANGUAGE" -> return getPlayersByLanguage(manager, args)
        "POLYGLOTS" -> return getPolyglots(manager, args)
        "MOST_USED_POSITIONS" -> return getMostUsedPositions(manager, args)
        "MOST_USED_ABYSSES" -> return getMostUsedAbysses(manager, args)
    }
    return null
}

/*
 * GET PLAYER <playerFirstName>
 * Obtém a informação do jogador cujo primeiro nome é igual ao parâmetro. A informação é a mesma que a apresentada pelo toString(), no mesmo formato
 * Ex:
 * GET PLAYER Ada
 * 3 | Ada Lovelace | 1 | No tools | Ada | Em Jogo
 * Caso o jogador não exista, deve retornar “Inexistent player”
 */
fun getPlayer(manager: GameManager, args: List<String>): String {
    return if (manager.players.filter { it.nome == args[1] }.joinToString { it.toString() }.isEmpty()) { "Inexistent player"
    } else { manager.players.filter { it.nome == args[1] }.joinToString { it.toString() } }
}

/*
 * GET PLAYERS_BY_LANGUAGE <language>
 * Obtém a lista de jogadores associados a uma certa linguagem, separados por vírgula.
 * Exemplo:
 * GET PLAYERS_BY_LANGUAGE Ruby
 * Pedro,Bruno
 * Caso não exista nenhum jogador associado a essa linguagem, deve escrever None
 */
fun getPlayersByLanguage(manager: GameManager, args: List<String>): String? {
    return manager.players.filter { it.temEstaLinguagem(args[1]) }.joinToString(",") { it.name }
}

/*
 * GET POLYGLOTS
 * Obtém a lista com todos os programadores associados a mais do que uma linguagem de programação,
 * ordenados por ordem crescente de número de linguagens. O resultado deve ser uma String com várias linhas em que cada linha tem o seguinte formato:
 * NOME_PROGRAMADOR:NUMERO_DE_LINGUAGENS
 * Exemplo:
 * Joshua Bloch:3 Brunito:4
 * Caso hajam empates, a ordem é indiferente.
 */
fun getPolyglots(manager: GameManager, args: List<String>): String? {
    return manager.players.filter{it.linguagens.size>1}.map { it.name + ":" + it.linguagens.filterNotNull().count() }.sorted().joinToString(",")
}

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
fun getMostUsedPositions(manager: GameManager, args: List<String>): String? {
    return manager.posicoesPisadas.map { it.key to it.value }.sortedByDescending { it.second }.take(Integer.parseInt(args[1])).joinToString("\n"){""+it.first+":"+it.second}
}

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
 */
fun getMostUsedAbysses(manager: GameManager, args: List<String>): String? {
    return manager.abismosPisados.map { it.key to it.value  }.sortedByDescending { it.second }.take(Integer.parseInt(args[1])).joinToString("\n"){""+it.first+":"+it.second}
}

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
fun PostMove(manager: GameManager, args: List<String>): String? {
    manager.moveCurrentPlayer(Integer.parseInt(args[1]))
    return if (manager.reactToAbyssOrTool() == null) { "OK" } else { manager.reactToAbyssOrTool() }
}

/* POST ABYSS <abyssTypeId> <position>
 * Insere um abismo do tipo abyssTypeId na posição indicada.
 * Caso tenha sucesso, deverá retornar “OK”.
 * Caso a posição já esteja ocupada por um abismo ou ferramenta, deverá retornar “Position is occupied”.
 * Apenas serão testados estes 2 casos.
 * Podem portanto assumir que o abyssTypeId é sempre válido e que a posição está dentro do tabuleiro.
 */

fun PostAbyss(manager: GameManager, args: List<String>): String? {
    return if (manager.addAbismo(Integer.parseInt(args[1]), Integer.parseInt(args[2]))) { "OK" } else { "Position is occupied" }
}