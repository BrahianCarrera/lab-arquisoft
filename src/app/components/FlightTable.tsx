import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, CircularProgress } from '@mui/material';

interface Flight {
  origin: string;
  destination: string;
  price?: number;
  equipment?: string;
  className?: string;
}

interface FlightTableProps {
  flights: Flight[];
  loading: boolean;
  error: string | null;
}

const FlightTable: React.FC<FlightTableProps> = ({ flights, loading, error }) => {
  if (loading) {
    return <CircularProgress />;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }

  return (
    <TableContainer component={Paper}>
      <Table aria-label="flight results table">
        <TableHead>
          <TableRow>
            <TableCell>Origin</TableCell>
            <TableCell>Destination</TableCell>
            <TableCell>Price</TableCell>
            <TableCell>Equipment</TableCell>
            <TableCell>Class</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {flights.map((flight, index) => (
            <TableRow key={index}>
              <TableCell>{flight.origin}</TableCell>
              <TableCell>{flight.destination}</TableCell>
              <TableCell>{flight.price}</TableCell>
              <TableCell>{flight.equipment}</TableCell>
              <TableCell>{flight.className}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default FlightTable;