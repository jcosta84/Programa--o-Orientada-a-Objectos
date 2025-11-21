public class TesteAutomovel {
    public static void main(String[] args) {
        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400); // a)

        System.out.println(a1); // b)

        System.out.println("Matrícula de a1: " + a1.getMatricula()); // c)

        a1.setCilindrada(1800); // d)

        System.out.println(a1); // e)

        System.out.println("Quantidade de instâncias: " + Automovel.getQuantidadeInstancias()); // f)

        Automovel a2 = new Automovel("22-22-BB", "Audi"); // g)

        System.out.println(a2); // h)

        // i) Mostrar quantidade de instâncias
        System.out.println("Quantidade de instâncias: " + Automovel.getQuantidadeInstancias()); // i)

        a2.setCilindrada(-2000); // j)

        System.out.println(a2); // k)

        a2.setCilindrada(2000); // l)

        System.out.println(a2); // m)

        System.out.println("Diferença de cilindrada entre a1 e a2: " + a1.diferencaCilindrada(a2) + " cc");  // n)
    }
}
