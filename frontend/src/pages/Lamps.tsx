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
import LampComponent from "../components/LampComponent";
import { Lamp } from "../interfaces/FurnitureTypes";

const Lamps: React.FC = () => {
  const [lamps, setLamps] = useState<Array<Lamp>>();

  const updateLamps = () => {
    fetch(`http://localhost:36295/lamps`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new lamps:", data);
        setLamps(data as Array<Lamp>);
      });
  };

  useLayoutEffect(() => {
    updateLamps();
  }, []);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonGrid>
            <IonRow>
              <IonTitle>Available Lamps</IonTitle>
              <IonButton onClick={updateLamps}>
                <IonIcon src={refreshOutline} />
              </IonButton>
            </IonRow>
          </IonGrid>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonList>
          {lamps?.map((v, k) => {
            return <LampComponent lamp={v} key={k} />;
          })}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Lamps;
