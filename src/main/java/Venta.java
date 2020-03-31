import java.time.LocalDate;
import java.util.List;

public class Venta {
    private LocalDate fecha;
    private List<Item> items;
    private FormaDePago formaDePago;

    public Venta(LocalDate fecha, List<Item> items, FormaDePago formaDePago) {
        this.fecha = fecha;
        this.items = items;
        this.formaDePago = formaDePago;
    }

    public Double precio() {
        double montoTotal = items.stream().mapToDouble(Item::getPrecioTotal).sum();
        return formaDePago.modificarMonto(montoTotal);
    }

    public boolean esDeFecha(LocalDate fechaDeterminada) {
        return fecha.isEqual(fechaDeterminada);
    }
}
