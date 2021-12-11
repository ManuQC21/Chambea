import {Habilidad} from "./habilidad.model";
import {RequiereHabilidad} from "./requiere-habilidad.model";
import {Duracion} from "./duracion.model";

export interface Trabajo {
  idTrabajo?: number,
  titulo: string,
  descripcion: string,
  duracion: Duracion,
  empleador: {
    idEmpleador: number,
    fechaRegistro?: string,
    compania?: string
  },
  habilidades: RequiereHabilidad[],
  postulaciones : Object[],
  fecha?: string
}
