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
import React, { useLayoutEffect, useState } from "react";
import FilingComponent from "../components/FilingComponent";
import { Filing } from "../interfaces/FurnitureTypes";

/**
 * Page for listing of all filings
 * @returns page to be rendered
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
const Filings: React.FC = () => {
  const [filings, setFilings] = useState<Array<Filing>>();

  /**
   * update filings from the database
   */
  const updateFilings = () => {
    fetch(`http://localhost:36295/filings`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new lamps:", data);
        setFilings(data as Array<Filing>);
      });
  };

  useLayoutEffect(() => {
    updateFilings();
  }, []);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonGrid>
            <IonRow>
              <IonTitle>Available Filing Cabinets</IonTitle>
              <IonButton onClick={updateFilings}>
                <IonIcon src={refreshOutline} />
              </IonButton>
            </IonRow>
          </IonGrid>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonList>
          {filings?.map((v, k) => {
            return <FilingComponent filing={v} key={k} />;
          })}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Filings;
