import { element, by } from 'protractor'

export class productosPages {

    private btnRegistrarProducto = element(by.xpath('/html/body/app-root/app-producto/div/nav/button'));
    private btnGuardarProducto = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[4]/button[1]'));

    private inputCodigo = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[1]/div[1]/div/input'));
    private inputGrupo = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[1]/div[2]/div/input'));
    private inputDescripcion = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[2]/input'));
    private inputPrecioVenta = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[3]/div[1]/div/input'));
    private inputPorcIva = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[3]/div[2]/div/input'));
    private inputPrecioCompra = element(by.xpath('/html/body/app-root/app-producto/app-crear-producto/div/div/div[2]/form/div[3]/div[3]/div/input'));
    
    public clickBtnRegistrarProducto() {
        this.btnRegistrarProducto.click(); 
    } 

    public llenarInputCodigo(codigo: string) {
        this.inputCodigo.sendKeys(codigo); 
    } 

    public llenarInputGrupo(grupo: string) {
        this.inputGrupo.sendKeys(grupo); 
    } 

    public llenarInputDescripcion(descripcion: string) {
        this.inputDescripcion.sendKeys(descripcion); 
    } 

    public llenarInputPrecioVenta(precioVenta: number) {
        this.inputPrecioVenta.sendKeys(precioVenta); 
    } 

    public llenarInputPorcIva(porcIva: number) {
        this.inputPorcIva.sendKeys(porcIva); 
    } 

    public llenarInputPrecioCompra(precioCompra: number) {
        this.inputPrecioCompra.sendKeys(precioCompra); 
    } 

    public clickBtnGuardarProducto() {
        this.btnGuardarProducto.click(); 
    } 
}