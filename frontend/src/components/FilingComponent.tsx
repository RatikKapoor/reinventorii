import { IonChip, IonItem, IonLabel, IonNote } from "@ionic/react";
import { FcFilingCabinet } from "react-icons/fc";
import "./ItemComponent.css";
import { Filing } from "../interfaces/FurnitureTypes";

/**
 * props to pass to the component
 * @author Ratik Kapoor, Robert Brown
 */
interface ContainerProps {
  filing: Filing;
}

/**
 * Filing Item Component
 * @param params filing information to be passed
 * @returns Filing componenet to be rendered
 * @author Ratik Kapoor, Robert Brown
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
