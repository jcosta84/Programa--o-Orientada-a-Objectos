public class Automovel {
    private String matricula;
    private String marca;
    private int cilindrada;
    private static int contadorInstancias = 0; // Contador de instâncias criadas

    // atributos
    public Automovel(String matricula, String marca, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        setCilindrada(cilindrada); // Usar o setter para validar
        contadorInstancias++;
    }

    // cilindrada
    public Automovel(String matricula, String marca) {
        this(matricula, marca, 1000);
    }

    // Getters para (maricula, marca, cilindrada)
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    // Setters para (matricula, marca, cilindrada)
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            System.out.println("Cilindrada inválida. Valor não alterado.");
        }
    }

    // automóvel
    @Override
    public String toString() {
        return "O Automóvel com matrícula " + matricula + " é um " + marca + 
               " e tem cilindrada de " + cilindrada + " cc.";
    }

    // Diferença da cilindrada entre dois automóveis
    public int diferencaCilindrada(Automovel outro) {
        return Math.abs(this.cilindrada - outro.getCilindrada());
    }

    // Verificar se este automóvel tem cilindrada superior a outro
    public boolean cilindradaSuperior(Automovel outro) {
        return this.cilindrada > outro.getCilindrada();
    }

    // Quantidade de instâncias criadas
    public static int getQuantidadeInstancias() {
        return contadorInstancias;
    }
}
