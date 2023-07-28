// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val name: String, val email: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.name} foi matriculado na formação $nome.")
        } else {
            println("${usuario.name} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    // Create some educational contents
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos e Estruturas de Dados", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Machine Learning", 150, Nivel.DIFICIL)

    // Create a formation and add the educational contents
    val formacao = Formacao("Formação em Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))

    // Create some users
    val user1 = Usuario("Alice", "alice@example.com", Nivel.INTERMEDIARIO)
    val user2 = Usuario("Bob", "bob@example.com", Nivel.BASICO)

    // Enroll users in the formation
    formacao.matricular(user1) // Output: Alice foi matriculada na formação Formação em Ciência da Computação.
    formacao.matricular(user2) // Output: Bob foi matriculado na formação Formação em Ciência da Computação.
    formacao.matricular(user1) // Output: Alice já está matriculada na formação Formação em Ciência da Computação.
}
