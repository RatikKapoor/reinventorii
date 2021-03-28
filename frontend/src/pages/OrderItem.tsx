import {
  IonContent,
  IonHeader,
  IonItem,
  IonLabel,
  IonList,
  IonPage,
  IonText,
  IonTitle,
  IonToolbar,
  IonInput,
  IonSelectOption,
  IonSelect,
  IonButton,
} from "@ionic/react";
import React, { useState } from "react";
import ChairComponent from "../components/ChairComponent";
import DeskComponent from "../components/DeskComponent";
import FilingComponent from "../components/FilingComponent";
import LampComponent from "../components/LampComponent";
import {
  Chair,
  Desk,
  Filing,
  IRESTMessage,
  Lamp,
  Manufacturer,
} from "../interfaces/FurnitureTypes";

const OrderItem: React.FC = () => {
  const [selectedItem, setSelectedItem] = useState<string>();
  const [selectedType, setSelectedType] = useState<string>();
  const [quantity, setQuantity] = useState<number>(1);
  const [output, setOutput] = useState<IRESTMessage | undefined>(undefined);
  const [manus, setManus] = useState<Array<Manufacturer>>();

  const requestItem = () => {
    fetch(
      `http://localhost:8080/builder/${selectedItem}?quantity=${quantity.toString()}`
    )
      .then((res) => res.json())
      .then((data) => {
        setOutput(data as IRESTMessage);
      });
  };

  const getManufacturers = () => {
    fetch(`http://localhost:8080/manufacturers`)
      .then((d) => d.json())
      .then((data) => {
        setManus(data);
      });
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Order a Item</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent>
        <IonItem>
          <IonLabel>Item</IonLabel>
          <IonSelect
            onIonChange={(e) => {
              setSelectedItem(e.detail.value);
              setSelectedType("");
            }}
            value={selectedItem}
          >
            <IonSelectOption value="Chair">Chair</IonSelectOption>
            <IonSelectOption value="Desk">Desk</IonSelectOption>
            <IonSelectOption value="Filing">Filing</IonSelectOption>
            <IonSelectOption value="Lamp">Lamp</IonSelectOption>
          </IonSelect>
        </IonItem>
        <IonItem>
          <IonLabel>Type</IonLabel>
          <IonSelect
            onIonChange={(e) => setSelectedType(e.detail.value)}
            value={selectedType}
          >
            {selectedItem === "Chair" && (
              <>
                <IonSelectOption value="Task">Task</IonSelectOption>
                <IonSelectOption value="Mesh">Mesh</IonSelectOption>
                <IonSelectOption value="Kneeling">Kneeling</IonSelectOption>
                <IonSelectOption value="Executive">Executive</IonSelectOption>
                <IonSelectOption value="Ergonomic">Ergonomic</IonSelectOption>
              </>
            )}
            {selectedItem === "Lamp" && (
              <>
                <IonSelectOption value="Desk">Desk</IonSelectOption>
                <IonSelectOption value="Swing Arm">Swing Arm</IonSelectOption>
                <IonSelectOption value="Study">Study</IonSelectOption>
              </>
            )}
            {selectedItem === "Desk" && (
              <>
                <IonSelectOption value="Traditional">
                  Traditional
                </IonSelectOption>
                <IonSelectOption value="Adjustable">Adjustable</IonSelectOption>
                <IonSelectOption value="Standing">Standing</IonSelectOption>
              </>
            )}
            {selectedItem === "Filing" && (
              <>
                <IonSelectOption value="Small">Small</IonSelectOption>
                <IonSelectOption value="Medium">Medium</IonSelectOption>
                <IonSelectOption value="Large">Large</IonSelectOption>
              </>
            )}
          </IonSelect>
        </IonItem>
        <IonItem>
          <IonLabel>Quantity</IonLabel>
          <IonInput
            type="number"
            value={quantity}
            onIonChange={(e) =>
              setQuantity(parseInt(e.detail.value ? e.detail.value : "1"))
            }
          />
        </IonItem>
        <IonItem>
          <IonButton>Request</IonButton>
        </IonItem>
        {output && (
          <>
            {output.success === true ? (
              <>
                <IonLabel>Success</IonLabel>
                <IonLabel>Components used:</IonLabel>
                {selectedItem === "Chair" &&
                  output.items.map((v, k) => {
                    <ChairComponent chair={v as Chair} key={k} />;
                  })}
                {selectedItem === "Desk" &&
                  output.items.map((v, k) => {
                    <DeskComponent desk={v as Desk} key={k} />;
                  })}
                {selectedItem === "Filing" &&
                  output.items.map((v, k) => {
                    <FilingComponent filing={v as Filing} key={k} />;
                  })}
                {selectedItem === "Lamp" &&
                  output.items.map((v, k) => {
                    <LampComponent lamp={v as Lamp} key={k} />;
                  })}
              </>
            ) : (
              <>
                <IonLabel>Failed!</IonLabel>
                <IonLabel>
                  Order cannot be fulfilled based on current inventory.
                  Suggested manufacturers are:{" "}
                  {manus?.map((manu) => {
                    return `${manu.name}, `;
                  })}
                </IonLabel>
              </>
            )}
          </>
        )}
      </IonContent>
    </IonPage>
  );
};

export default OrderItem;
