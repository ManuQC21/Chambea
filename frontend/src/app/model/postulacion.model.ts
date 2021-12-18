import {Trabajo} from "./trabajo.model";


export interface Postulacion {
  idPostulacion?: number,
  descripcion: string,
  fecha?: string
  trabajo: Trabajo,
  freelancer: {
    idFreelancer: number
  },
  estado: {
    idEstado: number,
    descripcion: string
  }
}
