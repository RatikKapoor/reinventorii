import { IonChip, IonItem, IonLabel, IonNote } from "@ionic/react";
import { GiDeskLamp } from "react-icons/gi";
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
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
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
