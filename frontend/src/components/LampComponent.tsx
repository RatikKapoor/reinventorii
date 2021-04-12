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

/**
 * props to pass to the component
 */
interface ContainerProps {
  lamp: Lamp;
}

/**
 * Lamp List Item Component
 * @param params lamp information to be passed
 * @returns Lamp componenet to be rendered
 */
const LampComponent: React.FC<ContainerProps> = ({ lamp }) => {
  return (
    <>
      <IonItem>
        <GiDeskLamp size={40} className="itemIcon" />
        <IonLabel>{`${lamp.type}: ${lamp.id}`}</IonLabel>
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
