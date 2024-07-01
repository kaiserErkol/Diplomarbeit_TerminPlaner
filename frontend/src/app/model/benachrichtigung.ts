import {Kunde} from "./kunde";

export interface Benachrichtigung {
  id: number,
  nachricht: string,
  datum: Date,
  kunde?: Kunde
}
