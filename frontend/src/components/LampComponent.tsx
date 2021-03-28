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
import { Lamp } from "../interfaces/FurnitureTypes";

interface ContainerProps {
  lamp: Lamp;
}

/**
 * icons:
 *  lamp - sunnyOutline
 *  chair: GiOfficeChair
 */

const LampComponent: React.FC<ContainerProps> = ({ lamp }) => {
  return (
    <>
      <IonItem>
        <GiDesk size="40" />
        <IonLabel>{lamp.type}</IonLabel>
        {lamp.base && <IonChip>Base</IonChip>}
        {lamp.bulb && <IonChip>Bulb</IonChip>}
        <IonNote slot="end" color="secondary" className="itemPrice">
          ${lamp.price.toString()}
        </IonNote>
      </IonItem>
    </>
  );
};

export default LampComponent;
