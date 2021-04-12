import {
  IonAvatar,
  IonChip,
  IonIcon,
  IonItem,
  IonLabel,
  IonNote,
} from "@ionic/react";
import { GiDesk } from "react-icons/gi";
import "./ItemComponent.css";
import { Desk } from "../interfaces/FurnitureTypes";

interface ContainerProps {
  desk: Desk;
}

/**
 * icons:
 *  lamp - sunnyOutline
 *  chair: GiOfficeChair
 */

const DeskComponent: React.FC<ContainerProps> = ({ desk }) => {
  return (
    <>
      <IonItem>
        <GiDesk size="40" className="itemIcon" />
        <IonLabel>{`${desk.type}: ${desk.id}`}</IonLabel>
        {desk.legs && <IonChip>Legs</IonChip>}
        {desk.top && <IonChip>Top</IonChip>}
        {desk.drawer && <IonChip>Drawer</IonChip>}
        <IonNote slot="end" color="secondary" className="itemPrice">
          ${desk.price.toString()}
        </IonNote>
      </IonItem>
    </>
  );
};

export default DeskComponent;
