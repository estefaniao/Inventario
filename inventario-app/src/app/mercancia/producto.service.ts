import { Injectable } from '@angular/core';
import { Producto } from './producto';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlEndPoint: string = 'http://localhost:8080/productos/';
  private urlEndPointUsuario: string = 'http://localhost:8080/usuario/';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }

  getProductos(): Observable<Producto[]> {
    return this.http.get<any>(this.urlEndPoint).pipe(
      map(response => response.data)
    );
  }

  guardarProducto(producto: Producto): Observable<Producto> {
    return this.http.post<any>(this.urlEndPoint, producto, {headers: this.httpHeaders}).pipe(
      map(response => response.data)
    );
  }

  actualizarProducto(id:any, producto: Producto): Observable<Producto>{
    return this.http.put<any>(`${this.urlEndPoint}${id}`, producto, {headers: this.httpHeaders}).pipe(
      map(response => response.data)
    );
  }

  eliminarProducto(id: any, usuario: any) {
    return this.http.delete<any>(`${this.urlEndPoint}${id}&${usuario}`, {headers: this.httpHeaders}).pipe(
      map(response => response.data))
  }

  obtenerUsuarios(): Observable<Usuario[]> {
    return this.http.get<any>(this.urlEndPointUsuario).pipe(
      map(response => response.data)
    )
  }

}
