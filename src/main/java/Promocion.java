public class Promocion implements Estado {
    private double valorFjo;

    public Promocion(double valorFjo) {
        this.valorFjo = valorFjo;
    }

    @Override
    public double getPrecio(Prenda prenda) {
        return prenda.getPrecioBase() - valorFjo;
    }
}
