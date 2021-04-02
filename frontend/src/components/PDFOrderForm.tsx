import React from 'react';
import { Document, Page, Text, View, StyleSheet, PDFViewer } from '@react-pdf/renderer';
import { GiOfficeChair } from "react-icons/gi";

const styles = StyleSheet.create({
  });

const MyDocument = () => (
    <Document>
      <Page size="Letter">
        <View>
            <Text>SCM Order</Text>
        </View>
        <View>
            <Text>Customer: User</Text>
            <Text>Order Number: 123</Text>
        </View>
        <View>
            <Text>Item Ordered</Text>
            <Text>Type</Text>
            <Text>Quantity</Text>
            <Text>Price</Text>
        </View>
      </Page>
    </Document>
  );

  const OrderView: React.FC = () => (
    <PDFViewer>
        <MyDocument />
    </PDFViewer>
  );

  export default OrderView;