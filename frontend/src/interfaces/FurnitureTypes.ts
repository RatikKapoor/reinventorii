import { type } from "node:os";

export interface FurniturePart {
  id: string;
  type: string;
  price: number;
  ManuID: string;
}

export interface Chair extends FurniturePart {
  legs: boolean;
  cushion: boolean;
  arms: boolean;
  seat: boolean;
}

export interface Desk extends FurniturePart {
  legs: boolean;
  top: boolean;
  drawer: boolean;
}

export interface Lamp extends FurniturePart {
  base: boolean;
  bulb: boolean;
}

export interface Filing extends FurniturePart {
  rails: boolean;
  drawers: boolean;
  cabinet: boolean;
}

export type Furniture = Chair | Desk | Lamp | Filing;

export interface Manufacturer {
  manuid: string;
  name: string;
  phone: string;
  province: string;
}
