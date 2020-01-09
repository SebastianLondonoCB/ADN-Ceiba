import { element, by } from 'protractor'

export class facturasPages {

    private btnRegistrarFactura = element(by.xpath('/html/body/app-root/app-factura/nav/button'));
    private btnGuardarFactura = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[4]/button[1]'));

    private inputIdFactura = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[1]/div[1]/div[1]/div/input'));
    private selectCliente = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[1]/div[1]/div[2]/div/select/option'));
    private selectProducto = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[2]/div/table/tbody[1]/tr/td[1]/select/option'));
    private inputPlazo = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[1]/div[2]/div[2]/div/input'));
    private inputCantida = element(by.xpath('/html/body/app-root/app-factura/app-crear-factura/div/div/div/form/div/div[2]/div[2]/div/table/tbody[1]/tr/td[2]/input'));
    
    public clickBtnRegistrarFactura() {
        this.btnRegistrarFactura.click(); 
    } 

    public llenarInputIdFactura(idFactura: string) {
        this.inputIdFactura.sendKeys(idFactura); 
    } 

    public llenarSelectCliente() {
        this.selectCliente.click(); 
    } 

    public clickInputPlazo() {
        this.inputPlazo.click(); 
    } 

    public llenarInputPlazo(plazo: string) {
        this.inputPlazo.sendKeys(plazo); 
    } 

    public llenarInputCantidad(cantidad: string) {
        this.inputCantida.sendKeys(cantidad); 
    } 

    public clickBtnGuardarFactura() {
        this.btnGuardarFactura.click(); 
    } 

    public llenarSelectProducto() {
        this.selectProducto.click(); 
    } 
}