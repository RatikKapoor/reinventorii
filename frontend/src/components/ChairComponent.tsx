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

/**
 * props to pass to the component
 * @author Ratik Kapoor, Robert Brown
 */
interface ContainerProps {
  chair: Chair;
}

/**
 * Chair List Item Component
 * @param props chair information to be passed
 * @returns Chair component to be rendered
 */
const ChairComponent: React.FC<ContainerProps> = ({ chair }) => {
  return (
    <>
      <IonItem>
        <GiOfficeChair size="40" className="itemIcon" />
        <IonLabel>{`${chair.type}: ${chair.id}`}</IonLabel>
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
