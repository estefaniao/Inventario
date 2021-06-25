import { Component, Output, EventEmitter, OnInit, Input } from '@angular/core';
import { Producto } from './producto';
import { ProductoService } from './producto.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  public producto: Producto = new Producto();
  public titulo:string = "Crear Producto"
  public usuarios: Usuario[] = [];
  @Output() newProdEvent = new EventEmitter<Producto>();
  @Input() seleccionado: Producto | undefined = undefined;

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.obtenerUsuarios().subscribe(res => this.usuarios = res)
  }

  ngOnChanges(changes: any) {
    if(changes.seleccionado.currentValue && Object.keys(changes.seleccionado.currentValue).length !== 0) {
      this.producto = {...changes.seleccionado.currentValue}
    }
  }

  addNewProduct(prod: Producto) {
    this.newProdEvent.emit(prod);
  }

   submitForm(){
    this.addNewProduct(this.producto);
    this.producto = new Producto();
  }

}
