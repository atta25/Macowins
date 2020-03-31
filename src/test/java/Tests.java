import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Tests {
    @Test
    public void cuandoLaPrendaEsNuevaElPrecioFinalDeberiaSerElMismo() {
        Prenda camisa = new Prenda(Tipo.CAMISA, new Nueva(), 250.0);
        assertEquals(250.0, camisa.getPrecioFinal(), 0.1);
    }

    @Test
    public void cuandoLaPrendaEstaEnPromocionElPrecioFinalDeberiaSerMenosElValorFijo() {
        Prenda pantalon = new Prenda(Tipo.PANTALON, new Promocion(2.5), 250.0);
        assertEquals(247.5, pantalon.getPrecioFinal(), 0.1);
    }

    @Test
    public void cuandoLaPrendaEstaEnLiquidacionElPrecioFinalDeberiaSerLaMitad() {
        Prenda saco = new Prenda(Tipo.SACO, new Liquidacion(), 250.0);
        assertEquals(125.0, saco.getPrecioFinal(), 0.1);
    }

    @Test
    public void cuandoLaVentaEsConEfectivoElPrecioDeberiaSerElMismo() {
        Prenda camisa = new Prenda(Tipo.CAMISA, new Nueva(), 250.0);
        Prenda pantalon = new Prenda(Tipo.PANTALON, new Nueva(), 250.0);
        Prenda saco = new Prenda(Tipo.SACO, new Nueva(), 250.0);
        Item item1 = new Item(1, camisa);
        Item item2 = new Item(1, pantalon);
        Item item3 = new Item(1, saco);
        List<Item> items = Arrays.asList(item1, item2, item3);

        Venta venta = new Venta(LocalDate.now(), items, new Efectivo());

        assertEquals(750.0, venta.precio(), 0.1);
    }

    @Test
    public void cuandoLaVentaEsConTarjetaElPrecioDeberiaSerSuperior() {
        Prenda camisa = new Prenda(Tipo.CAMISA, new Nueva(), 250.0);
        Prenda pantalon = new Prenda(Tipo.PANTALON, new Nueva(), 250.0);
        Prenda saco = new Prenda(Tipo.SACO, new Nueva(), 250.0);
        Item item1 = new Item(1, camisa);
        Item item2 = new Item(1, pantalon);
        Item item3 = new Item(1, saco);
        List<Item> items = Arrays.asList(item1, item2, item3);

        Venta venta = new Venta(LocalDate.now(), items, new Tarjeta(6, 0.7));

        assertEquals(761.7, venta.precio(), 0.1);
    }

    @Test
    public void gananciasDeUnaFechaDeterminadaTest() {
        Prenda camisa = new Prenda(Tipo.CAMISA, new Nueva(), 250.0);
        Prenda pantalon = new Prenda(Tipo.PANTALON, new Nueva(), 250.0);
        Prenda saco = new Prenda(Tipo.SACO, new Nueva(), 250.0);
        Item item1 = new Item(2, camisa);
        Item item2 = new Item(2, pantalon);
        Item item3 = new Item(1, saco);
        Venta venta1 = new Venta(LocalDate.of(2020, Month.FEBRUARY, 2), Arrays.asList(item1), new Efectivo());
        Venta venta2 = new Venta(LocalDate.of(2020, Month.FEBRUARY, 2), Arrays.asList(item1, item2), new Efectivo());
        Venta venta3 = new Venta(LocalDate.of(2020, Month.FEBRUARY, 3), Arrays.asList(item3), new Tarjeta(6, 0.7));

        Empresa macowins = new Empresa(Arrays.asList(venta1, venta2, venta3));

        assertEquals(0.0, macowins.gananciasDe(LocalDate.of(2020, Month.FEBRUARY, 1)), 0.1);
        assertEquals(1500.0, macowins.gananciasDe(LocalDate.of(2020, Month.FEBRUARY, 2)), 0.1);
        assertEquals(256.7, macowins.gananciasDe(LocalDate.of(2020, Month.FEBRUARY, 3)), 0.1);
    }
}
