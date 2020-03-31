public class Item {
    private Integer cantidad;
    private Prenda prenda;

    public Item(Integer cantidad, Prenda prenda) {
        this.cantidad = cantidad;
        this.prenda = prenda;
    }

    public double getPrecioTotal() {
        return cantidad * prenda.getPrecioFinal();
    }
}
