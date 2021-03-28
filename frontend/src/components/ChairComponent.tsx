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
import { Chair } from "../interfaces/FurnitureTypes";

interface ContainerProps {
  chair: Chair;
}

/**
 * icons:
 *  lamp - sunnyOutline
 *  chair: GiOfficeChair
 */

const ChairComponent: React.FC<ContainerProps> = ({ chair }) => {
  return (
    <>
      <IonItem>
        <GiOfficeChair size="40" className="itemIcon" />
        <IonLabel>{chair.type}</IonLabel>
        {chair.arms && <IonChip>Arms</IonChip>}
        {chair.cushion && <IonChip>Cushion</IonChip>}
        {chair.legs && <IonChip>Legs</IonChip>}
        {chair.seat && <IonChip>Seat</IonChip>}
        <IonNote slot="end" color="secondary" className="itemPrice">
          ${chair.price.toString()}
        </IonNote>
      </IonItem>
    </>
  );
};

export default ChairComponent;