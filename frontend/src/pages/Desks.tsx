import {
  IonButton,
  IonContent,
  IonGrid,
  IonHeader,
  IonIcon,
  IonList,
  IonPage,
  IonRow,
  IonTitle,
  IonToolbar,
} from "@ionic/react";
import { refreshOutline } from "ionicons/icons";
import React, { useEffect, useLayoutEffect, useState } from "react";
import DeskComponent from "../components/DeskComponent";
import { Desk } from "../interfaces/FurnitureTypes";

/**
 * Page for listing of all desks
 * @returns page to be rendered
 */
const Desks: React.FC = () => {
  const [desks, setDesks] = useState<Array<Desk>>();

  /**
   * update desks from the database
   */
  const updateDesks = () => {
    fetch(`http://localhost:36295/desks`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new desks:", data);
        setDesks(data as Array<Desk>);
      });
  };

  useLayoutEffect(() => {
    updateDesks();
  }, []);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonGrid>
            <IonRow>
              <IonTitle>Available Desks</IonTitle>
              <IonButton onClick={updateDesks}>
                <IonIcon src={refreshOutline} />
              </IonButton>
            </IonRow>
          </IonGrid>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonList>
          {desks?.map((v, k) => {
            return <DeskComponent desk={v} key={k} />;
          })}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Desks;
