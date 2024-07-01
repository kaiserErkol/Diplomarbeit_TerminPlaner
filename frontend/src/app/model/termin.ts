import {Timestamp} from "rxjs";
import {TerminStatus} from "../enum/termin-status";
import {Kunde} from "./kunde";
import {Fahrzeug} from "./fahrzeug";
import {Mitarbeiter} from "./mitarbeiter";

export interface Termin {
  id: number,
  datum: Date,
  uhrzeit: String,
  terminStatus: TerminStatus,
  notizen: String,
  kunde: Kunde,
  fahrzeug: Fahrzeug,
  mitarbeiter: Mitarbeiter
}
