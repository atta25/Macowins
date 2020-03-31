public class Prenda {
    private Tipo tipo;
    private Estado estado;
    private double precioBase;

    Prenda(Tipo tipo, Estado estado, double precioBase) {
        this.tipo = tipo;
        this.estado = estado;
        this.precioBase = precioBase;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return estado.getPrecio(this);
    }
}
