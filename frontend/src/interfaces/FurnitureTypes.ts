/**
 * Base furniture part
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface FurniturePart {
  id: string;
  type: string;
  price: number;
  ManuID: string;
}

/**
 * Chair interface
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface Chair extends FurniturePart {
  legs: boolean;
  cushion: boolean;
  arms: boolean;
  seat: boolean;
}

/**
 * Desk interface
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface Desk extends FurniturePart {
  legs: boolean;
  top: boolean;
  drawer: boolean;
}

/**
 * Lamp interface
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface Lamp extends FurniturePart {
  base: boolean;
  bulb: boolean;
}

/**
 * Filing interface
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface Filing extends FurniturePart {
  rails: boolean;
  drawers: boolean;
  cabinet: boolean;
}

/**
 * Type for any furniture
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export type Furniture = Chair | Desk | Lamp | Filing;

/**
 * Manufacturer interface
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
export interface Manufacturer {
  manuid: string;
  name: string;
  phone: string;
  province: string;
}
