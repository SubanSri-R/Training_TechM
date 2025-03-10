

import React, { useState } from 'react';
import { Card, Button, Modal, Form, Container, Row, Col } from 'react-bootstrap';

const NewsDashboard = ({ news, addNews, removeNews, onLogout }) => {
  const [selectedArticle, setSelectedArticle] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const [newArticle, setNewArticle] = useState({ title: '', description: '', content: '' });

  const handleArticleClick = (article) => {
    setSelectedArticle(article);
    setShowModal(true);
  };


  const handleAddArticle = () => {
    if (newArticle.title && newArticle.description && newArticle.content) {
      addNews(newArticle);
      setNewArticle({ title: '', description: '', content: '' });
      setShowModal(false); 
    } else {
      alert('Please fill all fields');
    }
  };


  const handleRemoveArticle = (index) => {
    removeNews(index);
  };

  return (
    <Container className="mt-5">
      <Row className="mb-4">
        <Col>
          <h2>News Dashboard</h2>
          <Button onClick={() => setShowModal(true)} className="me-2">
            Add News
          </Button>
          <Button variant="danger" onClick={onLogout}>
            Logout
          </Button>
        </Col>
      </Row>

      <Row>
        {news.map((article, index) => (
          <Col key={index} md={4} className="mb-4">
            <Card>
              <Card.Body>
                <Card.Title>{article.title}</Card.Title>
                <Card.Text>{article.description}</Card.Text>
                <Button variant="danger" onClick={() => handleRemoveArticle(index)}>
                  Remove
                </Button>
                <Button variant="info" onClick={() => handleArticleClick(article)} className="ms-2">
                  View Details
                </Button>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>

      <Modal show={showModal} onHide={() => setShowModal(false)} size="lg">
        <Modal.Header closeButton>
          <Modal.Title>{selectedArticle ? selectedArticle.title : 'Add News Article'}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {selectedArticle ? (
            <div>
              <h5>Description:</h5>
              <p>{selectedArticle.description}</p>
              <h5>Content:</h5>
              <p>{selectedArticle.content}</p>
            </div>
          ) : (
            <Form>
              <Form.Group controlId="formTitle" className="mb-3">
                <Form.Label>Title</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter title"
                  value={newArticle.title}
                  onChange={(e) => setNewArticle({ ...newArticle, title: e.target.value })}
                />
              </Form.Group>
              <Form.Group controlId="formDescription" className="mb-3">
                <Form.Label>Description</Form.Label>
                <Form.Control
                  as="textarea"
                  rows={2}
                  placeholder="Enter description"
                  value={newArticle.description}
                  onChange={(e) => setNewArticle({ ...newArticle, description: e.target.value })}
                />
              </Form.Group>
              <Form.Group controlId="formContent" className="mb-3">
                <Form.Label>Content</Form.Label>
                <Form.Control
                  as="textarea"
                  rows={4}
                  placeholder="Enter content"
                  value={newArticle.content}
                  onChange={(e) => setNewArticle({ ...newArticle, content: e.target.value })}
                />
              </Form.Group>
            </Form>
          )}
        </Modal.Body>
        <Modal.Footer>
          {selectedArticle ? (
            <Button variant="secondary" onClick={() => setShowModal(false)}>
              Close
            </Button>
          ) : (
            <Button variant="primary" onClick={handleAddArticle}>
              Add Article
            </Button>
          )}
        </Modal.Footer>
      </Modal>
    </Container>
  );
};

export default NewsDashboard;