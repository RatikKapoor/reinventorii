import {
  IonContent,
  IonHeader,
  IonItem,
  IonLabel,
  IonPage,
  IonTitle,
  IonToolbar,
  IonInput,
  IonSelectOption,
  IonSelect,
  IonButton,
  IonItemDivider,
} from "@ionic/react";
import React, { useEffect, useState } from "react";
import ChairComponent from "../components/ChairComponent";
import DeskComponent from "../components/DeskComponent";
import FilingComponent from "../components/FilingComponent";
import LampComponent from "../components/LampComponent";
import PDFOrderForm from "../components/PDFOrderForm";
import {
  Chair,
  Desk,
  Filing,
  Lamp,
  Manufacturer,
} from "../interfaces/FurnitureTypes";

const OrderItem: React.FC = () => {
  const [selectedItem, setSelectedItem] = useState<string>("");
  const [selectedType, setSelectedType] = useState<string>("");
  const [requestedItem, setRequestedItem] = useState<string>("");
  const [requestedType, setRequestedType] = useState<string>("");
  const [quantity, setQuantity] = useState<number>(1);
  const [output, setOutput] = useState<
    Array<Chair | Desk | Filing | Lamp> | undefined
  >(undefined);
  const [manus, setManus] = useState<Array<Manufacturer>>();
  const [faculty, setFaculty] = useState<string>("");
  const [contact, setContact] = useState<string>("");
  const [totalPrice, setTotalPrice] = useState<number>(0);
  const [orderPlaced, setOrderPlaced] = useState<boolean | undefined>(
    undefined
  );

  const placeOrder = () => {
    // TODO: Actually place order and remove from db
    fetch(
      `http://localhost:36295/remove?type=${selectedItem}&items=${output?.map(
        (v, k) => {
          return `${v.id}`;
        }
      )}`
    )
      .then((data) => data.text())
      .then((data) => {
        console.log("Got place order result:", data);
        if (data === "true") {
          setOrderPlaced(true);
        } else {
          setOrderPlaced(false);
        }
      });
  };

  const calculateTotalPrice = () => {
    let sum: number = 0;
    output?.forEach((furniture) => {
      sum = sum + furniture.price;
    });
    setTotalPrice(sum);
  };

  const requestItem = () => {
    fetch(
      `http://localhost:36295/builder/${selectedItem.toLowerCase()}?type=${selectedType}&number=${quantity.toString()}`
    )
      .then((res) => res.json())
      .then((data) => {
        setOutput(data);
        setRequestedItem(selectedItem);
        setRequestedType(selectedType);
        console.log(data);
        getManufacturers();
      });
  };

  const getManufacturers = () => {
    fetch(
      `http://localhost:36295/manufacturers?type=${selectedItem.toLowerCase()}`
    )
      .then((d) => d.json())
      .then((data) => {
        setManus(data);
      });
  };

  useEffect(() => {
    calculateTotalPrice();
  }, [output]);

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
            disabled={!selectedItem}
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
            min={"1"}
            onIonChange={(e) =>
              setQuantity(parseInt(e.detail.value ? e.detail.value : "1"))
            }
          />
        </IonItem>
        <IonItem>
          <IonButton
            onClick={requestItem}
            disabled={!(selectedItem && selectedType)}
          >
            Request
          </IonButton>
        </IonItem>
        {output && (
          <>
            {output && output.length > 0 ? (
              <>
                <IonItemDivider />
                <IonItem>
                  <IonLabel>Success! Components Used:</IonLabel>
                </IonItem>
                {requestedItem === "Chair" &&
                  output.map((v, k) => {
                    return <ChairComponent chair={v as Chair} key={k} />;
                  })}
                {requestedItem === "Desk" &&
                  output.map((v, k) => {
                    return <DeskComponent desk={v as Desk} key={k} />;
                  })}
                {requestedItem === "Filing" &&
                  output.map((v, k) => {
                    return <FilingComponent filing={v as Filing} key={k} />;
                  })}
                {requestedItem === "Lamp" &&
                  output.map((v, k) => {
                    return <LampComponent lamp={v as Lamp} key={k} />;
                  })}
                <IonItem>
                  <IonLabel style={{ textAlign: "right" }}>
                    Total cost:{" "}
                    <b style={{ color: "#3dc2ff" }}>${totalPrice}</b>
                  </IonLabel>
                </IonItem>
                <IonItemDivider />
                <IonItem>
                  <IonLabel>Faculty Name:</IonLabel>
                  <IonInput
                    placeholder="Schulich School of Engineering"
                    onIonChange={(e) => setFaculty(e.detail.value ?? "")}
                    autocomplete="organization"
                  />
                </IonItem>
                <IonItem>
                  <IonLabel>Contact:</IonLabel>
                  <IonInput
                    placeholder="Your Name"
                    onIonChange={(e) => setContact(e.detail.value ?? "")}
                    autocomplete="name"
                  />
                </IonItem>
                <IonItemDivider />
                <IonItem>
                  <IonButton
                    onClick={placeOrder}
                    disabled={!(faculty && contact)}
                  >
                    Place Order
                  </IonButton>
                </IonItem>
                <IonItemDivider />

                {orderPlaced === true && (
                  <>
                    <IonItem>Order placed!</IonItem>
                    <PDFOrderForm
                      items={output}
                      orderedItem={requestedItem}
                      orderedType={requestedType}
                      orderedQuantity={quantity}
                      faculty={faculty}
                      contact={contact}
                      price={totalPrice}
                    />
                  </>
                )}
                {orderPlaced === false && (
                  <>
                    <IonItem>
                      Could not order! Please try requesting again!
                    </IonItem>
                  </>
                )}
              </>
            ) : (
              <>
                <IonItemDivider />
                <IonItem>
                  <IonLabel>
                    Order cannot be fulfilled based on current inventory.
                    Suggested manufacturers are:
                    {manus?.map((manu) => {
                      return <IonItem>{manu.name}</IonItem>;
                    })}
                  </IonLabel>
                </IonItem>
              </>
            )}
          </>
        )}
      </IonContent>
    </IonPage>
  );
};

export default OrderItem;
