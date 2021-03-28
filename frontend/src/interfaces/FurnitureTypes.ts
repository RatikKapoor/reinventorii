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
