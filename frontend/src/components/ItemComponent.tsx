import {
  IonAvatar,
  IonChip,
  IonIcon,
  IonItem,
  IonLabel,
  IonNote,
} from "@ionic/react";
import { sunnyOutline } from "ionicons/icons";
import { GiOfficeChair, GiDeskLamp, GiDesk } from "react-icons/gi";
import { BsArchive } from "react-icons/bs";
import "./ItemComponent.css";

interface ContainerProps {
  id: string;
  type: string;
  price: Number;
}

/**
 * icons:
 *  lamp - sunnyOutline
 *  chair: GiOfficeChair
 */

const ItemComponent: React.FC<ContainerProps> = ({ id, type, price }) => {
  return (
    <>
      <IonItem>
        <GiOfficeChair />
        <IonLabel>{type}</IonLabel>
        <IonChip>Base</IonChip>
        <IonChip>Bulb</IonChip>
        <IonNote slot="end" color="secondary" className="itemPrice">
          ${price.toString()}
        </IonNote>
      </IonItem>
    </>
  );
};

export default ItemComponent;
