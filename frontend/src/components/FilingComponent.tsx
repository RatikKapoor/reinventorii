import {
  IonAvatar,
  IonChip,
  IonIcon,
  IonItem,
  IonLabel,
  IonNote,
} from "@ionic/react";
import { sunnyOutline } from "ionicons/icons";
import { FcFilingCabinet } from "react-icons/fc";
import { BsArchive } from "react-icons/bs";
import "./ItemComponent.css";
import { Filing } from "../interfaces/FurnitureTypes";

interface ContainerProps {
  filing: Filing;
}

/**
 * icons:
 *  lamp - sunnyOutline
 *  chair: GiOfficeChair
 */

const FilingComponent: React.FC<ContainerProps> = ({ filing }) => {
  return (
    <>
      <IonItem>
        <FcFilingCabinet size="40" className="itemIcon" />
        <IonLabel>{`${filing.type}: ${filing.id}`}</IonLabel>
        {filing.cabinet && <IonChip>Cabinet</IonChip>}
        {filing.drawers && <IonChip>Drawers</IonChip>}
        {filing.rails && <IonChip>Rails</IonChip>}
        <IonNote slot="end" color="secondary" className="itemPrice">
          ${filing.price.toString()}
        </IonNote>
      </IonItem>
    </>
  );
};

export default FilingComponent;
