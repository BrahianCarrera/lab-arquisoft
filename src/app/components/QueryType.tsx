import React, { useState } from 'react';
import Checkbox from './CheckBox';

interface QueryTypeProps {
  onInputChange1: (value: string) => void;
  onInputChange2: (value: string) => void;
  onInputChange3: (value: string) => void;
}

const QueryType: React.FC<QueryTypeProps> = ({
  onInputChange1,
  onInputChange2,
  onInputChange3
}) => {
  const [isChecked1, setIsChecked1] = useState(false);
  const [isChecked2, setIsChecked2] = useState(false);
  const [isChecked3, setIsChecked3] = useState(false);

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
      default:
        break;
    }
  };

  const handleInputChange = (setter: (value: string) => void) => (event: React.ChangeEvent<HTMLInputElement>) => {
    setter(event.target.value);
  };

  return (
    <>
      {isChecked1 && (
        <input
          type="text"
          onChange={handleInputChange(onInputChange1)}
          placeholder="Enter Origin"
        />
      )}
      <Checkbox
        label="Filter by Origin"
        checked={isChecked1}
        onChange={() => handleCheckboxChange(1)}
      />
      {isChecked2 && (
        <input
          type="text"
          onChange={handleInputChange(onInputChange2)}
          placeholder="Enter Destination"
        />
      )}
      <Checkbox
        label="Filter by Destination"
        checked={isChecked2}
        onChange={() => handleCheckboxChange(2)}
      />
      {isChecked3 && (
        <input
          type="text"
          onChange={handleInputChange(onInputChange3)}
          placeholder="Enter Max Price"
        />
      )}
      <Checkbox
        label="Filter by Max Price"
        checked={isChecked3}
        onChange={() => handleCheckboxChange(3)}
      />
    </>
  );
};

export default QueryType;
