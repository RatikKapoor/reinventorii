import { IonChip, IonItem, IonLabel, IonNote } from "@ionic/react";
import { GiDeskLamp } from "react-icons/gi";
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
