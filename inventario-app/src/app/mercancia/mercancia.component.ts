import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ProductoService } from './producto.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-mercancia',
  templateUrl: './mercancia.component.html'
})
export class MercanciaComponent implements OnInit {

  inventario: Producto[] = [];
  inventarioSeleccionado: Producto | undefined;
  usuarios: Usuario[] = [];
  usuarioPeticion = undefined;

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.getProductos().subscribe(
      inventario => this.inventario = inventario
    );
    this.productoService.obtenerUsuarios().subscribe(res => this.usuarios = res);
  }

  guardarProducto(producto: Producto): void{
    if (producto.idMercancia) {
      console.log('Editar', producto)
      this.productoService.actualizarProducto(producto.idMercancia, producto).subscribe((res: Producto) => {
        const idx = this.inventario.findIndex(i => i.idMercancia == res.idMercancia);
        this.inventario[idx] = res;
      })
    } else {
      this.productoService.guardarProducto(producto).subscribe((res) => this.inventario.push(res))
    }
  }

  seleccionarProducto(id:any): void{
    this.inventarioSeleccionado = this.inventario.find((i) => i.idMercancia === id)
  }

  eliminarProducto(id: any, usuario: any) {
    this.productoService.eliminarProducto(id, usuario).subscribe(() => {
      const newArray = this.inventario.filter(i => i.idMercancia !== id);
      this.inventario = newArray
    })
  }

  obtenerNombreUsuario(id: any) {
    return this.usuarios.find(u => u.idUsuario == id)?.nombreUsuario
  }

}
