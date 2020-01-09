import { facturasPages } from '../pages/crear-facturas';
import { browser } from 'protractor';

describe('Este es el paso a paso para el registro de una factura', () => { 
    const factura = new facturasPages();                                                                      

    it('Le damos clic en el botón de Registrar factura', () => { 
        browser.get('http://localhost:4200/factura/listar');                        
        factura.clickBtnRegistrarFactura();
    })

    it('Llenamos el campo de id factura', () => {                       
        factura.llenarInputIdFactura("FACT-100");
    })

    it('Seleccionamos el campo de cliente', () => {                       
        factura.llenarSelectCliente();
    })

    it('Damos click el campo de plazo', () => {                       
        factura.clickInputPlazo();
    })

    it('Llenamos el campo de plazo', () => {                       
        factura.llenarInputPlazo('5');
    })

    it('Seleccionamos el campo de producto', () => {                       
        factura.llenarSelectProducto();
    })
   
    it('Llenamos el campo de cantidad', () => {                       
        factura.llenarInputCantidad('2');
    })

    it('Le damos clic en el botón de guardar factura', () => {                      
        factura.clickBtnGuardarFactura();
    })
})