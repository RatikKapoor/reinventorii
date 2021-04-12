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
import { Desk } from "../interfaces/FurnitureTypes";

/**
 * props to pass to the component
 * @author Ratik Kapoor, Robert Brown
 */
interface ContainerProps {
  desk: Desk;
}

/**
 * Desk List Item Componenet
 * @param props desk information to be passed
 * @returns Desk component to be rendered
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
