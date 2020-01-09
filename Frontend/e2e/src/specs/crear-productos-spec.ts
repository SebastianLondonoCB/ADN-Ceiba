import { productosPages } from '../pages/crear-productos';
import { browser } from 'protractor';

describe('Este es el paso a paso para el registro de un producto', () => { 
    const producto = new productosPages();                                                                      

    it('Le damos clic en el botón de Registrar producto', () => { 
        browser.get('http://localhost:4200/producto/listar');                        
        producto.clickBtnRegistrarProducto();
    })

    it('Llenamos el campo de codigo', () => {                       
        producto.llenarInputCodigo("012345");
    })

    it('Llenamos el campo de grupo', () => {                       
        producto.llenarInputGrupo("Estuches");
    })

    it('Llenamos el campo de descripcion', () => {                       
        producto.llenarInputDescripcion("Escuche rojo para iPhone 11");
    })

    it('Llenamos el campo de precio venta', () => {                       
        producto.llenarInputPrecioVenta(70000);
    })

    it('Llenamos el campo de porcentaje de iva', () => {                       
        producto.llenarInputPorcIva(0);
    })

    it('Llenamos el campo de precio de compra', () => {                       
        producto.llenarInputPrecioCompra(45000);
    })

    it('Le damos clic en el botón de guardar producto', () => {                      
        producto.clickBtnGuardarProducto();
    })
})