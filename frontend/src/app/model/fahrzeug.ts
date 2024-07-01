import {Kunde} from "./kunde";

export interface Fahrzeug {
  id: number,
  marke: string,
  modell: string,
  baujahr: Date,
  kennzeichen: string,
  kunde?: Kunde,
}
