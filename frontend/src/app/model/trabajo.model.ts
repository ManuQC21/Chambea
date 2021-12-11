import {Habilidad} from "./habilidad.model";
import {RequiereHabilidad} from "./requiere-habilidad.model";

export interface Trabajo {
  idTrabajo?: number,
  titulo: string,
  descripcion: string,
  duracion: {
    idDuracion: number,
    descripcion: string
  },
  empleador?: {
    idEmpleador: number,
    fechaRegistro?: string,
    compania?: string
  },
  habilidades: RequiereHabilidad[],
  postulaciones : Object[],
  fecha?: string
}
