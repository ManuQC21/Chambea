import {Habilidad} from "./habilidad.model";

export interface Trabajo {
  idTrabajo: number,
  titulo: string,
  descripcion: string,
  idDuracion: {
    idDuracion: number,
    descripcion: string
  },
  idEmpleador: {
    idEmpleador: number,
    fechaRegistro?: string,
    compania?: string
  },
  habilidades: Habilidad[]
}
