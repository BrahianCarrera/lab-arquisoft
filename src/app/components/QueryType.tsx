import React, { useState } from 'react';
import Checkbox from '@mui/material/Checkbox';
import { FormControlLabel, Stack, TextField } from '@mui/material';

interface QueryTypeProps {
  onInputChange1: (value: string) => void;
  onInputChange2: (value: string) => void;
  onInputChange3: (value: string) => void;
  onInputChange4: (value: string) => void;
  onInputChange5: (value: string) => void;
}

const QueryType: React.FC<QueryTypeProps> = ({
  onInputChange1,
  onInputChange2,
  onInputChange3,
  onInputChange4,
  onInputChange5
}) => {
  const [isChecked1, setIsChecked1] = useState(false);
  const [isChecked2, setIsChecked2] = useState(false);
  const [isChecked3, setIsChecked3] = useState(false);
  const [isChecked4, setIsChecked4] = useState(false);
  const [isChecked5, setIsChecked5] = useState(false);

  const handleCheckboxChange = (index: number) => {
    switch (index) {
      case 1:
        setIsChecked1(!isChecked1);
        break;
      case 2:
        setIsChecked2(!isChecked2);
        break;
        case 3:
        setIsChecked3(!isChecked3);
        break;
        case 4:
        setIsChecked4(!isChecked4);
        break;
        case 5:
        setIsChecked5(!isChecked5);
        break;
      default:
        break;
    }
  };

  const handleInputChange = (setter: (value: string) => void) => (event: React.ChangeEvent<HTMLInputElement>) => {
    setter(event.target.value);
  };

  return (
    <>
    
  <Stack direction="column" spacing={1}>
  
  
  <FormControlLabel
    control={<Checkbox checked={isChecked1} onChange={() => handleCheckboxChange(1)} />}
    label="Filter by Origin"
  />

{isChecked1 && (
    <TextField
      type="text"
      
      onChange={handleInputChange(onInputChange1)}
      placeholder="Enter Origin"
    />
  )}

  
  <FormControlLabel
    control={<Checkbox checked={isChecked2} onChange={() => handleCheckboxChange(2)} />}
    label="Filter by Destination"
  />

{isChecked2 && (
    <TextField
      type="text"
      
      onChange={handleInputChange(onInputChange2)}
      placeholder="Enter Destination"
    />
  )}

  
  <FormControlLabel
    control={<Checkbox checked={isChecked3} onChange={() => handleCheckboxChange(3)} />}
    label="Filter by Max Price"
  />

{isChecked3 && (
    <TextField
      type="text"
      
      onChange={handleInputChange(onInputChange3)}
      placeholder="Enter Max Price"
    />
  )}

  
  <FormControlLabel
    control={<Checkbox checked={isChecked4} onChange={() => handleCheckboxChange(4)} />}
    label="Filter by Class Name"
  />

  {isChecked4 && (
    <TextField
      type="text"
      
      onChange={handleInputChange(onInputChange4)}
      placeholder="Enter Class Name"
    />
  )}

  <FormControlLabel
    control={<Checkbox checked={isChecked5} onChange={() => handleCheckboxChange(5)} />}
    label="Filter by Equipment"
  />

  {isChecked5 && (
    <TextField
      type="text"
      
      onChange={handleInputChange(onInputChange5)}
      placeholder="Enter Equipment"
    />
  )}
      </Stack>
    </>
  );
};

export default QueryType;
